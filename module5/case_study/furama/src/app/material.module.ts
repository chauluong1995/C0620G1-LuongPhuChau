import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DeleteDialogComponent} from "./components/employees/delete-dialog/delete-dialog.component";
import {MatDialogModule} from "@angular/material/dialog";
import {CreateEmployeeComponent} from "./components/employees/create-employee/create-employee.component";
import {EditEmployeeComponent} from "./components/employees/edit-employee/edit-employee.component";

@NgModule({
  imports: [
    BrowserAnimationsModule,
    MatDialogModule
  ],
  exports: [
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  entryComponents: [DeleteDialogComponent, CreateEmployeeComponent, EditEmployeeComponent]
})

export class MaterialModule {
}
