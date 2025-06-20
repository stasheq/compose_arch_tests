import UIKit
import SwiftUI
import ComposeApp
import MapKit

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(
            logger: IOSLogger(),
            mapView: makeMapView
        )
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    func makeMapView() -> UIViewController {
        let region = Binding.constant(
            MKCoordinateRegion(
                center: CLLocationCoordinate2D(latitude: 52.2423, longitude: 20.8962),
                span: MKCoordinateSpan(latitudeDelta: 0.1, longitudeDelta: 0.1)
            )
        )
        let mapView = Map(coordinateRegion: region)
        return UIHostingController(rootView: mapView)
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.all)
    }
}
