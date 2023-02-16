import { Pipe, PipeTransform } from "@angular/core";
import { Vendor } from "../../Classes/vendor";

@Pipe({name: 'vendordescr'})
export class VendorDescriptionPipe implements PipeTransform{

  transform(values: Vendor[], filter: string): Vendor[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Vendor) => {
      const vendorDescrFound =
        value.lookupId.description.toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (vendorDescrFound) {
        return value;
      }
    });
  }
}
