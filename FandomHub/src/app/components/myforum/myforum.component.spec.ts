import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyforumComponent } from './myforum.component';

describe('MyforumComponent', () => {
  let component: MyforumComponent;
  let fixture: ComponentFixture<MyforumComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MyforumComponent]
    });
    fixture = TestBed.createComponent(MyforumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
