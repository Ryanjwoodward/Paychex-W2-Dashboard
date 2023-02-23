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
import {CsvExportService} from "../../Services/csv-export.service";


@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.css']
})
export class DataTableComponent implements OnInit {

  //-------------------------------------
  //ENTITY DATA ARRAYS
  //-------------------------------------
/*  lookupTypes: LookupType[];
  lookupTables: LookupTable[];*/

  vendors: Vendor[];

  carriers: Carrier[];
  clients: Client[];

  //-------------------------------------
  // VENDOR PIPE-Filters
  //-------------------------------------
  venidfilter: string;
  vendorBranchFilter: string;
  vendorEmployeeFilter: string;
  vendorW2Filter: string;
  vendorLookupIdFilter:string;
  vendorDescriptionFilter:string;
  vendorAbbreviationFilter:string;
  vendorFullNameFilter: string;
  vendorStateFilter: string;

  //-------------------------------------
  // CARRIER PIPE-Filters
  //-------------------------------------
  carrierIdFilter: string;
  carrierBranchFilter: string;
  carrierDestAddrFilter: string;
  carrierTrackIdFilter:string;
  carrierLookupIdFilter:string;
  carrierAbbrevFilter: string;
  carrierDescripFilter:string;
  carrierFullnamefilter:string;
  carrierStateFilter:string;

  //-------------------------------------
  // CLIENT PIPE-Filters
  //-------------------------------------
  clientTransIdFilter:string;
  clientBranchFilter:string;
  clientCreatedDatefilter:string;
  clientEmployeeFilter:string;
  clientTransFileFilter:string;
  clientW2Filter:string;
  clientDeliveryAddressFilter:string;
  clientLookupIdFilter:string;
  clientStateFilter:string;

  //-------------------------------------------------------------------------
  constructor(private lookupTypeService: LookupTypeServiceService,
              private lookupTableService: LookupTableService,
              private vendorService: VendorService,
              private carrierService: CarrierService,
              private clientService: ClientService,
              private csvExportService: CsvExportService
  ) {
    /*this.getLookupTypes();
    this.getLookupTables();*/
    this.getVendors("0");
    this.getCarriers("0");
    this.getClients("0");
  }

  ngOnInit(): void {

  }

  public getVendors(selection:string){
    this.vendorService.getAllVendors(selection).subscribe(data =>{
      this.vendors = data;
    })

    /*this.vendorService.getVendorsByState().subscribe(data =>{
      this.vendors  = data;
    })*/
  }

  public getCarriers(selection: string){
    this.carrierService.getAllCarriers(selection).subscribe(data =>{
      this.carriers = data;
    })

  /*  this.carrierService.getCarriersByState().subscribe(data =>{
      this.carriers = data;
    })*/
  }

  public exportCSV(){
    console.log("entered export");
    this.csvExportService.callExportCSV();
    console.log("exit export");
  }



  //----- OLD, but Maybe USeful Methods
  /*
  private getLookupTypes(){
    this.lookupTypeService.getAllLookupTypes().subscribe(data => {
      this.lookupTypes = data;
    });
  }

  private getLookupTables(){
    this.lookupTableService.getAllLookupTables().subscribe(data =>{
      this.lookupTables = data;
    })
  }*/


  public getClients(selection: string){
    this.clientService.getAllClients(selection).subscribe(data =>{
      this.clients = data;
    })

    /*this.clientService.getClientsByState().subscribe(data =>{
      this.clients = data;
    })*/
  }


  public getEntitiesByState(state: String){

    this.vendorService.getVendorsByState().subscribe(data =>{
      this.vendors  = data;
    })

    this.carrierService.getCarriersByState().subscribe(data =>{
      this.carriers = data;
    })


    this.clientService.getClientsByState().subscribe(data =>{
      this.clients = data;
    })
  }//getEntitiesByState

}




