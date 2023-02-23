import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DataTableComponent } from './Components/data-table/data-table.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { VendorIdPipe } from "./Pipes/VendorPipes/vendor-id-pipe";
import { VendorBranchPipe } from "./Pipes/VendorPipes/vendor-branch-pipe";
import {VendorEmployeePipe} from "./Pipes/VendorPipes/vendor-employee-pipe";
import { VendorStatePipe } from "./Pipes/VendorPipes/vendor-state-pipe";
import {VendorNamePipe} from "./Pipes/VendorPipes/vendor-name-pipe";
import {VendorAbbreviationPipe} from "./Pipes/VendorPipes/vendor-abbreviation-pipe";
import {VendorDescriptionPipe} from "./Pipes/VendorPipes/vendor-description-pipe";
import {VendorW2Pipe} from "./Pipes/VendorPipes/vendor-w2-pipe";
import {VendorLookupidPipe} from "./Pipes/VendorPipes/vendor-lookupid-pipe";
import {CarrierAbbreviationPipe} from "./Pipes/CarrierPipes/carrier-abbreviation-pipe";
import {CarrierLookupIdPipe} from "./Pipes/CarrierPipes/carrier-lookup-id-pipe";
import {CarrierBranchPipe} from "./Pipes/CarrierPipes/carrier-branch-pipe";
import {CarrierDescriptionPipe} from "./Pipes/CarrierPipes/carrier-description-pipe";
import {CarrierDestinationPipe} from "./Pipes/CarrierPipes/carrier-destination-pipe";
import {CarrierStatePipe} from "./Pipes/CarrierPipes/carrier-state-pipe";
import {CarrierTrackingIdPipe} from "./Pipes/CarrierPipes/carrier-tracking-id-pipe";
import {CarrierIdPipe} from "./Pipes/CarrierPipes/carrier-id-pipe";
import {CarrierFullnamePipe} from "./Pipes/CarrierPipes/carrier-fullname-pipe";
import {ClientTxIdPipe} from "./Pipes/ClientPipes/client-tx-id-pipe";
import {ClientBranchPipe} from "./Pipes/ClientPipes/client-branch-pipe";
import {ClientCreatedDatePipe} from "./Pipes/ClientPipes/client-created-date-pipe";
import {ClientEmployeePipe} from "./Pipes/ClientPipes/client-employee-pipe";
import {ClientTxFilePipe} from "./Pipes/ClientPipes/client-tx-file-pipe";
import {ClientW2Pipe} from "./Pipes/ClientPipes/client-w2-pipe";
import {ClientDelvieryAddressPipe} from "./Pipes/ClientPipes/client-delviery-address-pipe";
import {ClientLookupIdPipe} from "./Pipes/ClientPipes/client-lookup-id-pipe";
import {ClientStatePipe} from "./Pipes/ClientPipes/client-state-pipe";
import { MatTableExporterModule } from "mat-table-exporter";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    DataTableComponent,
    VendorIdPipe,
    VendorBranchPipe,
    VendorEmployeePipe,
    VendorStatePipe,
    VendorNamePipe,
    VendorAbbreviationPipe,
    VendorDescriptionPipe,
    VendorW2Pipe,
    VendorLookupidPipe,
    CarrierAbbreviationPipe,
    CarrierLookupIdPipe,
    CarrierBranchPipe,
    CarrierDescriptionPipe,
    CarrierDestinationPipe,
    CarrierStatePipe,
    CarrierTrackingIdPipe,
    CarrierIdPipe,
    CarrierFullnamePipe,
    ClientTxIdPipe,
    ClientBranchPipe,
    ClientCreatedDatePipe,
    ClientEmployeePipe,
    ClientTxFilePipe,
    ClientW2Pipe,
    ClientDelvieryAddressPipe,
    ClientLookupIdPipe,
    ClientStatePipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatTableExporterModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent,
    DataTableComponent

  ]
})
export class AppModule { }
