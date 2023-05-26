import {Component, Input} from '@angular/core';
import {FacultyItem} from "../../model/FacultyItem";

@Component({
  selector: 'app-faculty-item',
  templateUrl: './faculty-item.component.html',
  styleUrls: ['./faculty-item.component.scss']
})
export class FacultyItemComponent {
  @Input()
  faculty = new FacultyItem();
}
