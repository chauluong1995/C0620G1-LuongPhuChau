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
  public list;
  public key = 'id';
  public reverse = false;
  term: any;
  p: any;

  constructor(
    public serviceConnectService: ServiceConnectService,
    public dialog: MatDialog
  ) {
  }

  ngOnInit() {
    this.serviceConnectService.getAll().subscribe(data => {
      this.list = data;
    })
  }

  openDialogDelete(id: any): void {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '950px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  openDialogEdit(id: any): void {
    this.serviceConnectService.findByID(id).subscribe(dataCar => {
      const dialogRefEdit = this.dialog.open(EditComponent, {
        width: '1050px',
        height: '1500px',
        data: {dataNeed: dataCar},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }
}
