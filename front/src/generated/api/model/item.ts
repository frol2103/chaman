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
import { Field } from './field';
import { Annex } from './annex';


export interface Item { 
    uuid?: string;
    title?: string;
    description?: string;
    content?: Array<Field>;
    annexes?: Array<Annex>;
}

