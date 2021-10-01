export * from './datatypes.service';
import { DatatypesService } from './datatypes.service';
export * from './field.service';
import { FieldService } from './field.service';
export * from './item.service';
import { ItemService } from './item.service';
export const APIS = [DatatypesService, FieldService, ItemService];
