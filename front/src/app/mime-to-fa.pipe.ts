import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mimeToFa'
})
export class MimeToFaPipe implements PipeTransform {
  static iconClasses = {
    // Media
    'image': 'fa-file-image',
    'audio': 'fa-file-audio',
    'video': 'fa-file-video',
    // Documents
    'application/pdf': 'fa-file-pdf',
    'application/msword': 'fa-file-word',
    'application/vnd.ms-word': 'fa-file-word',
    'application/vnd.oasis.opendocument.text': 'fa-file-word',
    'application/vnd.openxmlformats-officedocument.wordprocessingml': 'fa-file-word',
    'application/vnd.ms-excel': 'fa-file-excel',
    'application/vnd.openxmlformats-officedocument.spreadsheetml': 'fa-file-excel',
    'application/vnd.oasis.opendocument.spreadsheet': 'fa-file-excel',
    'application/vnd.ms-powerpoint': 'fa-file-powerpoint',
    'application/vnd.openxmlformats-officedocument.presentationml': 'fa-file-powerpoint',
    'application/vnd.oasis.opendocument.presentation': 'fa-file-powerpoint',
    'text/plain': 'fa-file-text',
    'text/html': 'fa-file-code',
    'application/json': 'fa-file-code',
    // Archives
    'application/gzip': 'fa-file-archive',
    'application/zip': 'fa-file-archive'
  };

  transform(value: string, ...args: unknown[]): string {
    if((value.startsWith("image") || value.startsWith("audio") || value.startsWith("video")) && value.indexOf("/")>=0){
      value = value.substr(0, value.indexOf("/"))
    }
    return (MimeToFaPipe.iconClasses)[value];
  }

}
