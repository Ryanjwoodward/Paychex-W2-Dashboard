import { Pipe, PipeTransform } from "@angular/core";
import { Vendor } from "../../Classes/vendor";

@Pipe({name: 'vendorlookupid'})
export class VendorLookupidPipe implements PipeTransform{

  transform(values: Vendor[], filter: string): Vendor[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Vendor) => {
      const vendorLookupIdFound =
        value.lookupId.lookupId.toString().toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (vendorLookupIdFound) {
        return value;
      }
    });
  }
}
