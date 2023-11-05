import { Component } from '@angular/core';
import { SalesPersonDetail } from './sales-person-detail';

@Component({
  selector: 'app-sales-person',
  templateUrl: './sales-person.component.bootstrap.html',
  styleUrls: ['./sales-person.component.css']
})
export class SalesPersonComponent {

  salesPersonList:SalesPersonDetail[]=[
    new SalesPersonDetail("Rahul","Kumar","rahul.kumar@gmail.com",8000000),
    new SalesPersonDetail("Anup","Kumar","anup.kumar@gmail.com",2425223423),
    new SalesPersonDetail("John","Kumar","john.kumar@gmail.com",234242),
    new SalesPersonDetail("Clarer","Kumar","clar.kumar@gmail.com",2432424),
  ];
  
}
