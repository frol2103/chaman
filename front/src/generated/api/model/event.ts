/**
 * Chaman
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface Event { 
    eventType?: Event.EventTypeEnum;
    itemId?: string;
    content?: string;
}
export namespace Event {
    export type EventTypeEnum = 'TakePicture' | 'TakeThumbnail';
    export const EventTypeEnum = {
        TakePicture: 'TakePicture' as EventTypeEnum,
        TakeThumbnail: 'TakeThumbnail' as EventTypeEnum
    };
}

