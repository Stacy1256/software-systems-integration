import {Component, OnInit} from '@angular/core';
import {FacultyService} from "../services/FacultyService";
import {FacultyItem} from "../../model/FacultyItem";

@Component({
  selector: 'app-faculties',
  templateUrl: './faculties.component.html',
  styleUrls: ['./faculties.component.scss']
})
export class FacultiesComponent implements OnInit {
  constructor(private facultyService: FacultyService) {
  }

  faculties: FacultyItem[] = [];

  ngOnInit() {
    this.facultyService.getFaculties().subscribe(faculties => {
      console.log(faculties);
      this.faculties = faculties;
    })
  }
}
