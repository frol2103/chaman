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
import { FieldValue } from './fieldValue';


export interface Field { 
    /**
     * single uuid acrross all version of the field
     */
    uuid?: string;
    label?: string;
    reference?: string;
    inputType?: string;
    value?: Array<FieldValue>;
    params?: any | null;
    errorMessages?: Array<string>;
    /**
     * true if the field is user defined false if its a deault field
     */
    isUserField?: boolean;
}

