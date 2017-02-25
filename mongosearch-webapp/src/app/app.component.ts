import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>{{title}}</h1>
    
    <mongo-search></mongo-search>
  `,
})
export class AppComponent {
  title = 'Demo';
}
