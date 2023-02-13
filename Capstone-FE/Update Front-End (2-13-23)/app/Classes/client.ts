import {LookupTable} from "./lookup-table";

export class Client {
  w2TransmissionId: string;
  branch: string;
  createdDate: string;
  employeeCount: number;
  transmissionFile: string;
  w2Count: number;
  w2DeliveryAddress: string;
  clientTypeId: LookupTable;
  deliveryCodeTypeId: LookupTable;
}
