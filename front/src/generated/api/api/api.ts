export * from './datatypes.service';
import { DatatypesService } from './datatypes.service';
export * from './field.service';
import { FieldService } from './field.service';
export * from './template.service';
import { TemplateService } from './template.service';
export const APIS = [DatatypesService, FieldService, TemplateService];
