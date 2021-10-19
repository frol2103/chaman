export * from './annex.service';
import { AnnexService } from './annex.service';
export * from './datatypes.service';
import { DatatypesService } from './datatypes.service';
export * from './field.service';
import { FieldService } from './field.service';
export * from './item.service';
import { ItemService } from './item.service';
export const APIS = [AnnexService, DatatypesService, FieldService, ItemService];
