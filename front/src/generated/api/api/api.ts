export * from './annex.service';
import { AnnexService } from './annex.service';
export * from './datatypes.service';
import { DatatypesService } from './datatypes.service';
export * from './event.service';
import { EventService } from './event.service';
export * from './field.service';
import { FieldService } from './field.service';
export * from './file.service';
import { FileService } from './file.service';
export * from './item.service';
import { ItemService } from './item.service';
export * from './thumbnail.service';
import { ThumbnailService } from './thumbnail.service';
export const APIS = [AnnexService, DatatypesService, EventService, FieldService, FileService, ItemService, ThumbnailService];
