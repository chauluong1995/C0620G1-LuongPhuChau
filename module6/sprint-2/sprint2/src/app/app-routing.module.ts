import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PayComponent} from './chau/pay/pay.component';
import {CommonModule} from '@angular/common';

const routes: Routes = [
  {path: 'pay', component: PayComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule],
  declarations: [PayComponent]
})
export class AppRoutingModule {
}
