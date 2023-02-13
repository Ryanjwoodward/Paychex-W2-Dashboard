import {BranchClient} from "./branch-client";
import {LookupTable} from "./lookup-table";

export class Carrier {
  carrierId: BranchClient;
  destinationAddress: string;
  trackingId: string;
  carrierLookupId: LookupTable;
  deliveryStatusTypeId: LookupTable;
}
