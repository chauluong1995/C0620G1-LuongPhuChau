import {Component, Input, OnInit} from '@angular/core';
import {studentDao} from "./student-dao";
import {IStudent} from "./IStudent";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})

export class StudentComponent implements OnInit {
  studentList = studentDao;
  studentParent: IStudent;
  studentCreate: IStudent;

  markChild = -1;
  check = false;
  test = false;

  constructor() {
  }

  ngOnInit(): void {
  }

  setDetail(student: IStudent) {
    this.studentParent = student;
    this.test = true;
  }

  getMarkChild(value: number) {
    this.check = true;
    this.markChild = value;
  }

  create() {
    this.test = false;
    this.studentCreate = new class implements IStudent {
      age: number;
      id: number;
      image: string;
      mark: number;
      name: string;
    };
    this.studentCreate.mark = 0;
  }
}
