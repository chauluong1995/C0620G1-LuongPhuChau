import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from "../student/IStudent";
import {studentDao} from "../student/student-dao";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  @Input() studentCreate: IStudent;
  studentList = studentDao;
  studentCreateNew: IStudent;

  constructor() { }

  ngOnInit() {
  }

  createNewStudent(name: string, age: string, mark: string) {
    this.studentCreateNew = {
      age: Number(age),
      id: Number(Math.random()),
      image: '',
      mark: Number(mark),
      name: name
    };
    this.studentList.push(this.studentCreateNew)
  }
}
