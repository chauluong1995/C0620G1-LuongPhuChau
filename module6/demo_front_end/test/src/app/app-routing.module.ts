import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {CommonModule} from "@angular/common";
import {NgxPaginationModule} from "ngx-pagination";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {MaterialModule} from "./material.module";
import {ListComponent} from './components/product/list/list.component';
import {DeleteComponent} from './components/product/delete/delete.component';
import {EditComponent} from './components/product/edit/edit.component';
import {OrderModule} from "ngx-order-pipe";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PrintComponent} from './components/product/print/print.component';
import {InputTicketComponent} from './components/product/input-ticket/input-ticket.component';

const routes: Routes = [
  {path: '', component: ListComponent},
  {path: 'inputTicket', component: InputTicketComponent},
  {path: 'delete', component: DeleteComponent},
  {path: 'print', component: PrintComponent},
  {path: 'edit', component: EditComponent},

  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), FormsModule, CommonModule, Ng2SearchPipeModule, NgxPaginationModule,
    ReactiveFormsModule, MaterialModule, OrderModule],
  exports: [RouterModule],
  declarations: [PageNotFoundComponent, ListComponent,
    DeleteComponent, EditComponent, PrintComponent, InputTicketComponent]
})
export class AppRoutingModule {
}
