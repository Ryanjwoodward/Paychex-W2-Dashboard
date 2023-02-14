import { Pipe, PipeTransform } from "@angular/core";
import {Client} from "../Classes/client";

// @ts-ignore
@Pipe({name: 'client'})
export class ClientPipe implements PipeTransform{

  transform(values: Client[], filter: string): Client[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Client) => {
      const w2TransId =
        value.w2TransmissionId.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const branch =
        value.branch.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const createdDate =
        value.createdDate.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const transfile =
        value.transmissionFile.toLowerCase().indexOf(filter.toLowerCase()) !== -1;
      const deliveryAddr =
        value.w2DeliveryAddress.toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (w2TransId || branch || createdDate || transfile || deliveryAddr) {
        return value;
      }
    });
  }
}
