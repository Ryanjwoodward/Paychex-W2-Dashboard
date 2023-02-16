import { Pipe, PipeTransform } from "@angular/core";
import { Vendor } from "../../Classes/vendor";

@Pipe({name: 'vendorstate'})
export class VendorStatePipe implements PipeTransform{

  transform(values: Vendor[], filter: string): Vendor[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Vendor) => {
      const vendorStateFound =
        value.lookupId.state.toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (vendorStateFound) {
        return value;
      }
    });
  }
}
