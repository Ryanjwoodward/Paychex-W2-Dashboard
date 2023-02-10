import { Component, OnInit } from '@angular/core';
import {LookupType} from "../../Classes/lookup-type";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LookupTypeServiceService} from "../../Services/lookup-type-service.service";
import {LookupTable} from "../../Classes/lookup-table";
import {LookupTableService} from "../../Services/lookup-table-service.service";
import {Vendor} from "../../Classes/vendor";
import {VendorService} from "../../Services/vendor.service";
import {Carrier} from "../../Classes/carrier";
import {CarrierService} from "../../Services/carrier.service";
import {ClientService} from "../../Services/client.service";
import {Client} from "../../Classes/client";

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.css']
})
export class DataTableComponent implements OnInit {

  lookupTypes: LookupType[];
  lookupTables: LookupTable[];

  vendors: Vendor[];

  carriers: Carrier[];
  clients: Client[];

  filter: string;
  filter1: string;
  filter2: string;

  constructor(private lookupTypeService: LookupTypeServiceService,
              private lookupTableService: LookupTableService,
              private vendorService: VendorService,
              private carrierService: CarrierService,
              private clientService: ClientService
  ) {
    this.getLookupTypes();
    this.getLookupTables();
    this.getVendors();
    this.getCarriers();
    this.getClients();
  }

  ngOnInit(): void {

  }

  private getLookupTypes(){
    this.lookupTypeService.getAllLookupTypes().subscribe(data => {
      this.lookupTypes = data;
    });
  }

  private getLookupTables(){
    this.lookupTableService.getAllLookupTables().subscribe(data =>{
      this.lookupTables = data;
    })
  }

  private getVendors(){
    this.vendorService.getAllVendors().subscribe(data =>{
      this.vendors = data;
    })

    /*this.vendorService.getVendorsByState().subscribe(data =>{
      this.vendors  = data;
    })*/
  }

  private getCarriers(){
    this.carrierService.getAllCarriers().subscribe(data =>{
      this.carriers = data;
    })

  /*  this.carrierService.getCarriersByState().subscribe(data =>{
      this.carriers = data;
    })*/
  }

  private getClients(){
    this.clientService.getAllClients().subscribe(data =>{
      this.clients = data;
    })

    /*this.clientService.getClientsByState().subscribe(data =>{
      this.clients = data;
    })*/
  }

}
