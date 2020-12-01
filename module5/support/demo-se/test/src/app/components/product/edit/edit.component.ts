import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {MatDatepicker} from "@angular/material/datepicker";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  public formEdit: FormGroup;
  public typeListEdit;
  public statusListEdit;
  public idNeed;
  public startDateTS = new Date('yyyy/MM/dd');
  public endDateTS = new Date('yyyy/MM/dd');
  public minDate = new Date();
  public testStartDate = 'true';
  public testEndDate = 'true';

  constructor(
    public dialogRef: MatDialogRef<EditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public serviceConnectService: ServiceConnectService,
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAllType().subscribe(dataType => {
      this.typeListEdit = dataType;
    });

    this.serviceConnectService.getAllStatus().subscribe(dataType => {
      this.statusListEdit = dataType;
    });

    this.formEdit = this.formBuilder.group({
      idFormat: [this.data.dataNeed.idFormat],
      area: [this.data.dataNeed.area, [Validators.required, Validators.min(30.000001)]],
      floors: [this.data.dataNeed.floors, [Validators.required, Validators.min(1), Validators.max(15)]],
      rentPrice: [this.data.dataNeed.rentPrice, [Validators.required, Validators.min(5000000.000001)]],
      startDate: [this.data.dataNeed.startDate, Validators.required],
      endDate: [this.data.dataNeed.endDate, Validators.required],
      type: [this.data.dataNeed.type.name, Validators.required],
      status: [this.data.dataNeed.status.name, Validators.required]
    });
  }

  edit() {
    if (this.formEdit.valid) {
      this.idNeed = this.data.dataNeed.id;

      if (this.testEndDate === 'false') {
        this.formEdit.value.startDate.setDate(this.startDateTS.getDate() - 183);
      }

      if (this.testStartDate === 'false') {
        this.formEdit.value.endDate.setDate(this.endDateTS.getDate() + 183);
      }

      for (let element of this.typeListEdit) {
        if (element.name === this.formEdit.value.type) {
          this.formEdit.value.type = element;
          break;
        }
      }

      for (let element of this.statusListEdit) {
        if (element.name === this.formEdit.value.status) {
          this.formEdit.value.status = element;
          break;
        }
      }

      this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
        this.dialogRef.close();
      })
    }
  }

  changeStartDate(startDate: MatDatepicker<any>, endDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testStartDate === 'true') {
      this.startDateTS.setDate(this.startDateTS.getDate() + 183);
      this.testEndDate = 'false'
    }
  }

  changeEndDate(endDate: MatDatepicker<any>, startDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.endDateTS = endDate._datepickerInput.value;
    if (this.testEndDate === 'true') {
      this.endDateTS.setDate(this.endDateTS.getDate() - 183);
      this.testStartDate = 'false';
    }
  }
}
