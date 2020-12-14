import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ServiceConnectService} from "../../../services/service-connect.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  // public formEdit: FormGroup;
  // public startPlaceEdit;
  // public endPlaceEdit;
  // public idNeed;
  // public numberCarNeed;

  constructor(
    // public dialogRef: MatDialogRef<EditComponent>,
    // @Inject(MAT_DIALOG_DATA) public data: any,
    // public formBuilder: FormBuilder,
    // public serviceConnectService: ServiceConnectService,
  ) {
  }

  ngOnInit() {
    // this.numberCarNeed = this.data.dataNeed.numberCar;
    //
    // this.serviceConnectService.getAllStartPlace().subscribe(dataStartPlace => {
    //   this.startPlaceEdit = dataStartPlace;
    // });
    //
    // this.serviceConnectService.getAllEndPlace().subscribe(dataEndPlace => {
    //   this.endPlaceEdit = dataEndPlace;
    // });
    //
    // this.formEdit = this.formBuilder.group({
    //   numberCar: [this.data.dataNeed.numberCar],
    //   type: [this.data.dataNeed.type, Validators.required],
    //   nameCar: [this.data.dataNeed.nameCar, Validators.required],
    //   phone: [this.data.dataNeed.phone, [Validators.required,
    //     Validators.pattern('^(090|093|097)(\\d{7})$')]],
    //   email: [this.data.dataNeed.email,
    //     [Validators.required, Validators.pattern('^[a-zA-Z0-9]+[@]([a-zA-Z]{3,7})[.]([a-z]{2,3})$')]],
    //   startPlace: [this.data.dataNeed.startPlace.name, Validators.required],
    //   endPlace: [this.data.dataNeed.endPlace.name, Validators.required],
    //   startHours: [this.data.dataNeed.startHours, Validators.required],
    //   endHours: [this.data.dataNeed.endHours, Validators.required],
    // });
  }

  // edit() {
  //   if (this.formEdit.valid) {
  //     this.idNeed = this.data.dataNeed.id;
  //
  //     for (let element of this.startPlaceEdit) {
  //       if (element.name === this.formEdit.value.startPlace) {
  //         this.formEdit.value.startPlace = element;
  //         break;
  //       }
  //     }
  //
  //     for (let element of this.endPlaceEdit) {
  //       if (element.name === this.formEdit.value.endPlace) {
  //         this.formEdit.value.endPlace = element;
  //         break;
  //       }
  //     }
  //
  //     this.serviceConnectService.editService(this.formEdit.value, this.idNeed).subscribe(data => {
  //       this.dialogRef.close();
  //     })
  //   }
  // }
}
