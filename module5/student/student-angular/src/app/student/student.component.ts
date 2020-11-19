import {Component, OnInit} from '@angular/core';
import {IStudent} from "./IStudent";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  studentInfor: IStudent = {
    id: 1,
    name: 'Storm Shadow',
    age: 18,
    mark: 10,
    image: 'assets/storm.jpg'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

}
