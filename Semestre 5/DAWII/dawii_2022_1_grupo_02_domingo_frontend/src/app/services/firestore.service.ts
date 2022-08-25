import { UserInterface } from 'src/app/models/userInterface';
import { Injectable } from '@angular/core';
import {
  Firestore,
  collection,
  addDoc,
  collectionData,
  doc,
  docData,
  setDoc,
} from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FirestoreService {
  constructor(private firestore: Firestore) {}

  createDoc(data: UserInterface, uid: string) {
    return setDoc(doc(this.firestore, 'Usuarios', uid), data);
  }

  getUser(): Observable<UserInterface[]> {
    const userRef = collection(this.firestore, 'Usuarios');
    return collectionData(userRef) as Observable<UserInterface[]>;
  }

  getUserById(uid: string): Observable<UserInterface> {
    const userRef = doc(this.firestore, `Usuarios/${uid}`);
    return docData(userRef) as Observable<UserInterface>;
  }
  getUserById_1(uid: string) {
    const userRef = doc(this.firestore, `Usuarios/${uid}`);
    return docData(userRef);
  }
}
