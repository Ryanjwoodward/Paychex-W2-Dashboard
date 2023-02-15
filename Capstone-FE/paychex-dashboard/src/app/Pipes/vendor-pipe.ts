import { Pipe, PipeTransform } from "@angular/core";
import { Vendor } from "../Classes/vendor";

@Pipe({name: 'vendor'})
export class VendorPipe implements PipeTransform{

  transform(values: Vendor[], filter: string): Vendor[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Vendor) => {
      const branchFound =
        value.vendorId.branch.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const clientIdFound =
        value.vendorId.clientId.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const clientAbbrev =
        value.lookupId.abbreviation.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const venDescription =
        value.lookupId.description.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const  venLookupId =
        value.lookupId.lookupId.toString().toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const venW2Count =
        value.w2Count.toString().toLowerCase().indexOf((filter.toLowerCase())) !== -1;
      const venEmpCount =
        value.employeeCount.toString().toLowerCase().indexOf(filter.toLowerCase()) !== -1;



      if (branchFound || clientIdFound || clientAbbrev || venDescription || venLookupId || venEmpCount || venW2Count) {
        return value;
      }
    });
  }
}


