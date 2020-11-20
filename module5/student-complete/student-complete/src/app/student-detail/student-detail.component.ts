import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from "../student/IStudent";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  @Input() studentParent: IStudent;

  @Output() changeMarkParent = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  changeMark(value: number) {
    this.studentParent.mark = value;
    this.changeMarkParent.emit(value)
  }
}
