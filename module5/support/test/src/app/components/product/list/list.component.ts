import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ServiceConnectService} from "../../../services/service-connect.service";
import {CreateComponent} from "../create/create.component";
import {DeleteComponent} from "../delete/delete.component";
import {EditComponent} from "../edit/edit.component";
import {DetailComponent} from "../detail/detail.component";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public list;
  public objectNeed = null;
  public key = 'id';
  public reverse = false;
  public listChoose: Array<any> = [];
  term: any;
  p: any;
  private create;
  keyName: any;
  keyPrice: any;

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

  resetSearch() {
    this.term = "";
    this.keyName = "";
    this.keyPrice = "";
    this.listChoose = [];
    this.searchOfMe("", "");
    this.reverse = false;
    this.key = 'id';
    this.objectNeed = null;
  }

  createNewDialog() {
    const dialogRefCreate = this.dialog.open(CreateComponent, {
      width: '950px',
      height: '1500px',
      data: {dataNeed: this.create},
      disableClose: true
    });

    dialogRefCreate.afterClosed().subscribe(result => {
      this.ngOnInit()
    })
  }

  openDialogDelete(id: any): void {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRef = this.dialog.open(DeleteComponent, {
        width: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  openDialogEdit(id: any): void {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRefEdit = this.dialog.open(EditComponent, {
        width: '950px',
        height: '1500px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  openDialogView(id: any) {
    this.serviceConnectService.findByID(id).subscribe(varialble => {
      const dialogRefEdit = this.dialog.open(DetailComponent, {
        width: '950px',
        height: '750px',
        data: {dataNeed: varialble},
        disableClose: true
      });

      dialogRefEdit.afterClosed().subscribe(result => {
        this.ngOnInit()
      })
    });
  }

  searchOfMe(keyName: string, keyPrice: string) {
    if (keyPrice !== "" && keyName !== "") {
      // this.serviceConnectService.findByNameAndPrice(keyName, keyPrice).subscribe(data => {
      this.serviceConnectService.findByNameAndType(keyName, keyPrice).subscribe(data => {
        this.list = data;
      });
    } else {
      if (keyName === "") {
        // this.serviceConnectService.findByPrice(keyPrice).subscribe(data => {
        this.serviceConnectService.findByType(keyPrice).subscribe(data => {
          this.list = data;
        });
      } else if (keyPrice === "") {
        this.serviceConnectService.findByName(keyName).subscribe(data => {
          this.list = data;
        });
      }
    }
  }

  chooseDelete(value: any) {
    let test = 'true';
    if (this.listChoose.length === 0) {
      this.listChoose.push(value);
    } else {
      for (let element of this.listChoose) {
        if (element == value) {
          test = 'false'
        }
      }
      if (test === 'true') {
        this.listChoose.push(value);
      }
    }
  }

  deleteAllChoosed() {
    if (this.listChoose.length !== 0) {
      this.serviceConnectService.deleteService(this.listChoose.shift()).subscribe(data => {
        this.deleteAllChoosed()
      })
    }
    if (this.serviceConnectService.getAll().subscribe()) {
      this.ngOnInit()
    }
  }

  sortInTable(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  setDetail(element: any) {
    element.hiddenIcon = false;
    this.objectNeed = element;
  }

  setProperty(value: string) {
    this.objectNeed.name = value;
    this.objectNeed.hiddenIcon = true;
    this.serviceConnectService.editService(this.objectNeed, this.objectNeed.id).subscribe(data => {
      if (this.serviceConnectService.getAll().subscribe()) {
        this.ngOnInit()
      }
    })
  }

  // sort(attribute: any, arrange: any) {
  //   console.log('có vô');
  //   if (arrange === "asc" && attribute === "price") {
  //     console.log('price asc');
  //     this.serviceConnectService.sortByPriceASC().subscribe(data => {
  //       this.list = data;
  //     });
  //   }
  //   if (arrange === "desc" && attribute === "price") {
  //     this.serviceConnectService.sortByPriceDESC().subscribe(data => {
  //       this.list = data;
  //     });
  //   }
  //
  //   if (arrange === "asc" && attribute === "name") {
  //     this.serviceConnectService.sortByNameASC().subscribe(data => {
  //       this.list = data;
  //     });
  //   }
  //   if (arrange === "desc" && attribute === "name") {
  //     this.serviceConnectService.sortByNameDESC().subscribe(data => {
  //       this.list = data;
  //     });
  //   }
  //
  //   if (arrange === "asc" && attribute === "id") {
  //     this.serviceConnectService.sortByIDASC().subscribe(data => {
  //       this.list = data;
  //     });
  //   }
  //   if (arrange === "desc" && attribute === "id") {
  //     this.serviceConnectService.sortByIDDESC().subscribe(data => {
  //       this.list = data;
  //     });
  //   }
  // }
}
