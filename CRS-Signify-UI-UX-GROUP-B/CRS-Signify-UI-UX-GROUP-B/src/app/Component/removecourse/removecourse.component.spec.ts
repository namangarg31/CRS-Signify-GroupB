import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemovecourseComponent } from './removecourse.component';

describe('RemovecourseComponent', () => {
  let component: RemovecourseComponent;
  let fixture: ComponentFixture<RemovecourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RemovecourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RemovecourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
