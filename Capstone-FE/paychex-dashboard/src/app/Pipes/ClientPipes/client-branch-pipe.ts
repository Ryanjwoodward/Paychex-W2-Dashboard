import { Pipe, PipeTransform } from "@angular/core";
import {Client} from "../../Classes/client";

// @ts-ignore
// @ts-ignore
@Pipe({name: 'clientbranch'})
export class ClientBranchPipe implements PipeTransform{

  transform(values: Client[], filter: string): Client[] {
    if (!filter || filter.length === 0) {
      return values;
    }

    if (values.length === 0) {
      return values;
    }

    // @ts-ignore
    return values.filter((value: Client) => {
      const foundValue =
        value.branch.toLowerCase().indexOf(filter.toLowerCase()) !== -1;

      if (foundValue) {
        return value;
      }
    });
  }
}
