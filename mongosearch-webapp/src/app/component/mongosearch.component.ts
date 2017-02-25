import {Client} from "../objects/client";
import {Component} from "@angular/core";
import {ClientService} from "../service/client.service";

/**
 * Created by Herve on 22/02/2017.
 */

@Component({
  moduleId: module.id,
  selector: 'mongo-search',
  templateUrl: 'mongosearch.component.html',
  styleUrls: ['mongosearch.component.css'],
  providers: [ClientService]
})

export class MongoSearchComponent {
  clients : Client[] = [];
  errorMessage: string;
  mode = 'Observable';

  constructor(private clientService: ClientService) {
  }

  getClients(name : string): void {
    this.clientService.getClients(name)
      .subscribe(
        clients => this.clients = clients,
        error => this.errorMessage = <any>error);
  }

  onChange(text: HTMLInputElement) {
    if (text.value.length > 2) {
      this.getClients(text.value);
    } else {
      this.clients = [];
    }
  }
}
