import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {MatDatepicker} from "@angular/material/datepicker";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public formCreateNew: FormGroup;
  public typeList;
  public statusList;
  public startDateTS = new Date('yyyy/MM/dd');
  public minDate = new Date();

  constructor(
    private serviceConnectService: ServiceConnectService,
    public dialogRef: MatDialogRef<CreateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public formBuilder: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAllType().subscribe(dataType => {
      this.typeList = dataType;
    });

    this.serviceConnectService.getAllStatus().subscribe(dataType => {
      this.statusList = dataType;
    });

    this.formCreateNew = this.formBuilder.group({
      idFormat: ['', {
        validators: [Validators.required,
          Validators.pattern('^([A-Z0-9]{3})(-)([A-Z0-9]{2})(-)([A-Z0-9]{2})$')],
        asyncValidators: [this.serviceConnectService.validateID()],
        updateOn: 'blur'
      }],
      area: ['', [Validators.required, Validators.min(30.000001)]],
      floors: ['', [Validators.required, Validators.min(1), Validators.max(15)]],
      rentPrice: ['', [Validators.required, Validators.min(5000000.000001)]],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      type: ['', Validators.required],
      status: ['', Validators.required]
    });
  }

  createNew() {
    if (this.formCreateNew.valid) {
      this.formCreateNew.value.startDate.setDate(this.formCreateNew.value.startDate.getDate() - 183);

      for (let element of this.typeList) {
        if (element.name == this.formCreateNew.value.type) {
          this.formCreateNew.value.type = element;
          break;
        }
      }

      for (let element of this.statusList) {
        if (element.name == this.formCreateNew.value.status) {
          this.formCreateNew.value.status = element;
          break;
        }
      }

      this.serviceConnectService.createNewService(this.formCreateNew.value).subscribe(data => {
        this.dialogRef.close();
      })
    }
  }

  changeStartDate(startDate: MatDatepicker<any>) {
    this.startDateTS = startDate._datepickerInput.value;
    this.startDateTS.setDate(this.startDateTS.getDate() + 183);
  }
}
