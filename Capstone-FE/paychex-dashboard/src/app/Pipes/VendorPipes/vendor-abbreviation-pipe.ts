import { Pipe, PipeTransform } from "@angular/core";
import { Vendor } from "../../Classes/vendor";

@Pipe({name: 'vendorabbrev'})
export class VendorAbbreviationPipe implements PipeTransform{

  transform(values: Vendor[], filter: string): Vendor[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Vendor) => {
      const vendorAbbrevFound =
        value.lookupId.abbreviation.toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (vendorAbbrevFound) {
        return value;
      }
    });
  }
}
