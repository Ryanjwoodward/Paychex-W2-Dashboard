import {BranchClient} from "./branch-client";
import {LookupTable} from "./lookup-table";

export class Vendor {
  vendorId: BranchClient;
  employeeCount: number;
  w2Count: number;
  lookupId: LookupTable;
}
