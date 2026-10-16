% Tutorial 10 - Question 7
% Rule-based parking slot allocation

% a) Facts: parking_slot(Slot, VehicleType, Availability)
parking_slot(s1, car, available).
parking_slot(s2, bike, occupied).
parking_slot(s3, car, available).
parking_slot(s4, bike, available).
parking_slot(s5, car, occupied).

% b) Rule to find an available slot for a vehicle type
available_slot(Type, Slot) :-
    parking_slot(Slot, Type, available).

% c) Query for available car parking slots:
% ?- available_slot(car, Slot).
% Expected results:
% Slot = s1 ;
% Slot = s3.
