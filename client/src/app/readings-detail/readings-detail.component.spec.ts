import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReadingsDetailComponent } from './readings-detail.component';

describe('ReadingsDetailComponent', () => {
  let component: ReadingsDetailComponent;
  let fixture: ComponentFixture<ReadingsDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReadingsDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReadingsDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
