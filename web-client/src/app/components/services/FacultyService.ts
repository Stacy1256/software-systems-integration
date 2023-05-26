import {Injectable} from '@angular/core';

import {Apollo, gql} from 'apollo-angular';
import {map, Observable} from 'rxjs';
import {FacultyItem} from "../../model/FacultyItem";

@Injectable({
  providedIn: 'root'
})
export class FacultyService {
  constructor(private apollo: Apollo) {
  }

  getFaculties(): Observable<FacultyItem[]> {
    return this.apollo.watchQuery({
      query: gql`
          query FacultyConnection {
              faculties {
                  facultyConnection {
                      nodes {
                          id
                          name
                          website
                          email
                          phone
                          address
                          logoUri
                      }
                  }
              }
          }
      `
    }).valueChanges.pipe(map((response: any) => response.data?.faculties?.facultyConnection?.nodes || []));
  }
}
