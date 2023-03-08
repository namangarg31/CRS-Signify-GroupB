import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewunapproveComponent } from './viewunapprove.component';

describe('ViewunapproveComponent', () => {
  let component: ViewunapproveComponent;
  let fixture: ComponentFixture<ViewunapproveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewunapproveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewunapproveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
