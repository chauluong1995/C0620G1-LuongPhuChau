import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PayComponent} from './chau/pay/pay.component';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {SuccessfullyPayComponent} from './chau/successfully-pay/successfully-pay.component';
import {MatDialogModule} from '@angular/material/dialog';

const routes: Routes = [
  {path: 'pay', component: PayComponent},
  {path: '', component: PayComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule, FormsModule, MatDialogModule],
  exports: [RouterModule],
  declarations: [PayComponent, SuccessfullyPayComponent],
  entryComponents: [SuccessfullyPayComponent]
})
export class AppRoutingModule {
}
