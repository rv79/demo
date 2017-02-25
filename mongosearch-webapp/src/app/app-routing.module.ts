import {Routes, RouterModule} from "@angular/router";
import {MongoSearchComponent} from "./component/mongosearch.component";
import {NgModule} from "@angular/core";

/**
 * Created by Herve on 22/02/2017.
 */

const routes: Routes = [
  { path: '', redirectTo: '/mongoSearch', pathMatch: 'full' },
  { path: 'mongoSearch',  component: MongoSearchComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
