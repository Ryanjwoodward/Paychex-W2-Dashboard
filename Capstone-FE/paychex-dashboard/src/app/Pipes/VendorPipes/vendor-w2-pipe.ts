import { Pipe, PipeTransform } from "@angular/core";
import { Vendor } from "../../Classes/vendor";

@Pipe({name: 'vendorw2'})
export class VendorW2Pipe implements PipeTransform{

  transform(values: Vendor[], filter: string): Vendor[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Vendor) => {
      const vendorW2CountFound =
        value.w2Count.toString().toLowerCase().indexOf((filter.toLowerCase())) !== -1;

      if (vendorW2CountFound) {
        return value;
      }
    });
  }
}
