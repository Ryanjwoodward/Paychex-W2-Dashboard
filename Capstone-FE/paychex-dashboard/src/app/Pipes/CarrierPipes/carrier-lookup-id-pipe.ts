import { Pipe, PipeTransform } from "@angular/core";
import { Carrier } from "../../Classes/carrier";

// @ts-ignore
@Pipe({name: 'carlookid'})
export class CarrierLookupIdPipe implements PipeTransform{

  transform(values: Carrier[], filter: string): Carrier[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Carrier) => {
      const valueFound =
        value.carrierLookupId.lookupId.toString()
          .toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (valueFound) {
        return value;
      }
    });
  }
}
