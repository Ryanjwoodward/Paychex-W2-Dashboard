import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.scss']
})
export class DefaultComponent implements OnInit {
// this is for left side above three lines in side bar and for three lines to work
  sideBarOpen = true;

  constructor() { }

  ngOnInit() { }

//makes the sidebar appear and disappear
  sideBarToggler($event: any) {
    this.sideBarOpen = !this.sideBarOpen;
  }

}
