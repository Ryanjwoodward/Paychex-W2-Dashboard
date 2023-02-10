import { Pipe, PipeTransform } from "@angular/core";
import { Carrier } from "../Classes/carrier";
import {Vendor} from "../Classes/vendor";

// @ts-ignore
@Pipe({name: 'carrier'})
export class CarrierPipe implements PipeTransform{

  transform(values: Carrier[], filter: string): Carrier[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Carrier) => {
      const branchFound =
        value.carrierId.branch.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const carrierId =
        value.carrierId.clientId.toString().toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const carAddress =
        value.destinationAddress.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const  trackId =
        value.trackingId.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const description =
        value.carrierLookupId.fullName.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const fullName =
        value.deliveryStatusTypeId.fullName.toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (branchFound || carrierId || carAddress || trackId || description || fullName) {
        return value;
      }
    });
  }
}
