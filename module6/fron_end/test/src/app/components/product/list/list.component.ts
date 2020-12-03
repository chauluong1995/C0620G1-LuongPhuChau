import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {DeleteComponent} from "../delete/delete.component";
import {EditComponent} from "../edit/edit.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  protected list;

  constructor(
    public serviceConnectService: ServiceConnectService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {

  }

  openDialogDelete(id: any): void {
    // this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '750px',
        height: '320px',
        // data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    // });
  }

  openDialogEdit(id: any): void {
    // this.serviceConnectService.findByID(id).subscribe(dataCar => {
      const dialogRefEdit = this.dialog.open(EditComponent, {
        width: '750px',
        height: '390px',
        // data: {dataNeed: dataCar},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    // });
  }
}
