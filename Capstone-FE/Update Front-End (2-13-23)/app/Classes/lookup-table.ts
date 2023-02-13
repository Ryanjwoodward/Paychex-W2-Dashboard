import {LookupType} from "./lookup-type";

export class LookupTable {
  lookupId: number;
  abbreviation: string;
  description: string;
  fullName: string;
  lookupTypeId: LookupType;

  state: string;
}
